#Block API

###Summary:
This is a spring boot app, with mysql as the database.  I have included the database named *conf_tech_dump* at the root level. If you choose to run
this application locally clone the repository then navigate to the root level of the application.  Import the sql dump into your a local
mysql instance.  Change the datasource parameters to your local values inside the application.properties file in the resources folder.


The most IDE neutral way run this application would be to navigate the root of the project via the command line and and execute the command
  *'gradle clean build'*.  After that is done, you can now fire up the executable jar the has been created by executing the command at project root
  *'java -jar build/libs/block_api-1.0.0.jar'*
  

#Resource Documentation
##Create Block

=====================================================================
*URL Local:* localhost:8080/block
*Payload Example:* {"color":"testing","shape":"the","pattern":"properties"}
*URL AWS :* PENDING
*HTTP Method:* POST
###cURLs
*cURL Local:* curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{"color":"testing","shape":"the","pattern":"properties"}'
'http://localhost:8080/block'
*cURL AWS:*PENDING

##Get Block

=====================================================================
*URL Local:* localhost:8080/block/id/{int}
*URL AWS :* PENDING
*HTTP Method:* GET
###cURLs
*cURL Local:* curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" 'http://localhost:8080/block/id/1'
*cURL AWS:* PENDING

##Get Blocks by color

=====================================================================
*URL Local:* localhost:8080/block/blocks/color/{string}limit/{int}
*URL AWS :* PENDING
*HTTP Method:* GET
###cURLs
*cURL Local:* curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" 'http://localhost:8080/block/blocks/color/red/limit/3'
*cURL AWS:* PENDING

##Get Blocks by pattern

=====================================================================
*URL Local:*  localhost:8080/block/blocks/pattern/{string}/limit/{int}
*URL AWS :* PENDING
*HTTP Method:* GET
###cURLs
*cURL Local:* curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" 'http://localhost:8080/block/blocks/pattern/flannel/limit/0'
*cURL AWS:* PENDING

##Get Blocks by shape

=====================================================================
*URL Local:* localhost:8080/block/blocks/shape/{string}/limit/{int}
*URL AWS :* PENDING
*HTTP Method:* GET
###cURLs
*cURL Local:* curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" 'http://localhost:8080/block/blocks/shape/square/limit/2'
*cURL AWS:* PENDING

##Delete Block

=====================================================================
*URL Local:* localhost:8080/block/id/{int}
*URL AWS :* PENDING
*HTTP Method:* DELETE
###cURLs
*cURL Local:* curl -X DELETE -H "Content-Type: application/json" -H "Cache-Control: no-cache" 'http://localhost:8080/block/id/2'
*cURL AWS:* PENDING 

##Update Block

=====================================================================
*URL Local:* localhost:8080/block/id/{int}
*URL AWS :* PENDING
*HTTP Method:* PUT
###cURLs
*cURL Local:* curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{"color":"update color","pattern":"update pattern","shape":"update shape"}' 'http://localhost:8080/block/id/111'
*cURL AWS:* PENDING

