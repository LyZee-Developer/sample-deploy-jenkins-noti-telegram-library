def call(String Username,String ImageName,String BuilNumber){
    sh """

        echo '--------------- Processing build image is starting 👌---------------'
        docker build -t ${Username}/${ImageName}:${BuilNumber} .
        echo '--------------- Push image to docker👌 ---------------'
        docker push ${Username}/${ImageName}:${BuilNumber}
        echo '--------------- Push image to docker👌 ---------------'
        docker stop sample-jenkin-cont  |  true
        docker rm sample-jenkin-cont  |  true
        docker run -dp 8004:80 --name sample-jenkin-cont ${Username}/${ImageName}:${BuilNumber}

    """
}   