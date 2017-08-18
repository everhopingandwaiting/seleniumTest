##  selenium hub




```$xslt

java -jar selenium-server-standalone-3.5.0.jar -role node ;


 sudo docker pull selenium/hub ;
 
 sudo docker pull selenium/node-firefox ;
 
 sudo docker pull selenium/node-chrome ;
 
 
 
 ## run 
 
    sudo docker run -p 5555:4444 -d --name 'selenium_hub'  selenium/hub ;
    sudo docker ps ;
    
    ## node register 
    
    sudo docker run -P -d --link selenium_hub:hub selenium/node-firefox ; 
    
        # or    sudo docker run -P -d --link selenium_hub:hub selenium/node-chrome ;
        # or sudo docker run -P -d --name 'firefox-node1'  --link selenium_hub:hub selenium/node-firefox ;
      
     # cat  logs selenium hub
     
     sudo docker logs selenium_hub ;
    
    
    # see in browser 
    
    ip：http://192.168.0.222:5555/grid/console
    
```