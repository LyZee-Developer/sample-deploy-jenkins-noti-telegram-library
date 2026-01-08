def call(String message,String status,String Chat_Id,string Token){
    def msg = "${message}"
    sh """
        curl -s -X POST "https://api.telegram.org/bot${token}/sendMessage" \
        -d chat_id=${Chat_Id} \
        -d text="${msg}" \
        -d parse_mode=MarkdownV2
    """
}