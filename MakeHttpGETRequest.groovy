import groovy.json.JsonSlurper

class MakeHttpGETRequest {
    static void main(String[] args) {
        def docker_image_tags_url = "https://hub.docker.com/v2/repositories/library/mysql/tags/?page_size=20"
// Set requirements for the HTTP GET request, you can add Content-Type headers and so on...
        def http_client = new URL(docker_image_tags_url).openConnection() as HttpURLConnection
        http_client.setRequestMethod('GET')
        // Run the HTTP request
        http_client.connect()
        //http_client.inputStream.getText('UTF-8')
        def dockerhub_response = new JsonSlurper().parseText(http_client.inputStream.getText('UTF-8'))
        // Prepare a List to collect the tag names into
        def image_tag_list = []
        dockerhub_response.results.each { tag_metadata ->
            //image_tag_list.add(tag_metadata.name)
            //println(tag_metadata.name)
            image_tag_list.add(tag_metadata.name)
        }

        image_tag_list.each {tag_metadata ->
            println(tag_metadata)
        }
    }
}
