#!/bin/sh

helm delete testapp
oc delete pvc data-testapp-postgresql-0 
