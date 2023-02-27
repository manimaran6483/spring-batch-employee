#!/bin/bash

resourceGroup='javafunctionsgrp'
storageAccount='azjavafuncstorageaccnt'
functionPlan='PremiumPlan'

echo "Creating Resource Group - ${resourceGroup}"

az group create --name $resourceGroup --location eastus
echo "Resource Group Created Successfully - ${resourceGroup}"

echo "Creating Storage Account - ${storageAccount}" 
az storage account create --name $storageAccount --location eastus --resource-group $resourceGroup --sku Standard_LRS
echo "Storage Account Created Successfully - ${storageAccount}" 

echo "Creating Premium Plan - ${functionPlan} " 
az functionapp plan create --resource-group $resourceGroup --name $functionPlan --location eastus --number-of-workers 1 --sku EP1 --is-linux
echo "Premium Plan Created Successfully - ${functionPlan} " 

echo "Creating Azure Function App"
az functionapp create --name batchfunction-20230122215154917 --storage-account $storageAccount --resource-group $resourceGroup --plan $functionPlan --deployment-container-image-name manimaran6483/batchfunction:v1.0.5 --os linux --runtime java --functions-version 4
echo "Azure Function App Created Successfully" 
