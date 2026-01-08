def call(String username,String password){
    sh """ 
        echo '${password}' | docker login -u ${username} --password-stdin
    """
}