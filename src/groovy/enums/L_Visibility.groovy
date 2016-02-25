package enums

/**
 * Created by ayush on 12/2/16.
 */
enum L_Visibility {
    PUBLIC,
    PRIVATE

    static changeStringInVisibility(String inputText) {
        if (inputText) {
            inputText = inputText.toUpperCase()
          if(PUBLIC == inputText as L_Visibility){
              return PUBLIC
          }  else{
              return PRIVATE
          }
        }
    }
}
