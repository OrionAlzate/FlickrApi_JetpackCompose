package com.ormadev.tekus.util

class Constants {

    companion object{

        const val BASE_URL = "https://www.flickr.com/services/rest/"
        const val ENDPOINT = "?method=flickr.interestingness.getList&api_key="
        const val API_KEY = "40bd373bb6a19a078023b06af055d03c"
        const val EXTRAS = "&extras=url_h&format=json&nojsoncallback=1"
        const val COMLETE_ENDPOINT  = "?method=flickr.interestingness.getList&api_key=40bd373bb6a19a078023b06af055d03c&extras=url_h&format=json&nojsoncallback=1"
    }
}

// https://www.flickr.com/services/rest/?method=flickr.interestingness.getList&api_key=40bd373bb6a19a078023b06af055d03c&extras=url_h&format=json&nojsoncallback=1