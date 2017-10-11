Pixlotto Web Interface

configuration can be found in: config.yml
* server -> applicationConnectors -> port configures on which port the app will run
* imagePath is the upload directory for the images
* lottoPath is the config file for the pixlotto core lib

Start the server with the following command („cd pixlotto“ first!):
java -jar bin/pixweb-1.0.0.jar server config.yml