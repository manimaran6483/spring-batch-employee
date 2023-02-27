#!/bin/bash

#Variables
resourceGroup='javafunctionsgrp'
storageAccount='azjavafuncstorageaccnt'
functionPlan='PremiumPlan'
response=''


az_login(){

response=$(az login -u $1 -p $2 )


if [ `echo $?` -ne 0 ]
then
echo "Login Failed"
echo $response
exit 1
else
echo "Login Success"
fi
}

create_resource_group(){

echo "Creating Resource Group - ${resourceGroup}"

response=$(az group create --name $resourceGroup --location eastus)


if [ `echo $?` -ne 0 ]
then
echo "Resource Group Creation Failed - ${resourceGroup}"
echo $response
exit 1
else
echo "Resource Group Created Successfully - ${resourceGroup}"
fi

}

create_storage_account(){

echo "Creating Storage Account - ${storageAccount}"

response=$(az storage account create --name $storageAccount --location eastus --resource-group $resourceGroup --sku Standard_LRS)

if [ `echo $?` -ne 0 ]
then
echo "Storage Account Creation Failed - ${storageAccount}"
echo $response
exit 1
else
echo "Storage Account Created Successfully - ${storageAccount}"
fi

}

create_premium_plan(){

echo "Creating Premium Plan - ${functionPlan} "
response=$(az functionapp plan create --resource-group $resourceGroup --name $functionPlan --location eastus --number-of-workers 1 --sku EP1 --is-linux)


if [ `echo $?` -ne 0 ]
then
echo "Premium Plan Creation Failed - ${functionPlan}"
echo $response
exit 1
else
echo "Premium Plan Created Successfully - ${functionPlan} "
fi

}

create_function_app(){
echo "Creating Azure Function App"
response=$(az functionapp create --name batchfunction-20230122215154917 --storage-account $storageAccount --resource-group $resourceGroup --plan $functionPlan --deployment-container-image-name manimaran6483/batchfunction:v1.0.5 --os linux --runtime java --functions-version 4)

if [ `echo $?` -ne 0 ]
then
echo "Azure Function App Failed"
echo $response
exit 1
else

echo "Azure Function App Created Successfully"
fi

}


#az_login username password
create_resource_group
create_storage_account
create_premium_plan
create_function_app



