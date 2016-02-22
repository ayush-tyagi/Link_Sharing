package enums

import grails.plugin.cache.SerializableOutputStream

/**
 * Created by ayush on 11/2/16.
 */
enum Seriousness {
    SERIOUS,
    CASUAL,
    VERY_SERIOUS

    static Seriousness changeStringInSeriousness(String inputText){
    if(inputText){
        inputText = inputText.toUpperCase()
        if(SERIOUS == inputText as Seriousness){
            return SERIOUS
        }else if(CASUAL == inputText as Seriousness){
            return CASUAL
        }else if(VERY_SERIOUS == inputText as Seriousness){
         return VERY_SERIOUS
        }
    }
    }
}

