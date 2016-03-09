// Place your Spring DSL code here
beans = {
    simpleBean(SimpleBean){
        name = "Krishna"
        age = 24
    }
    simpleBeanUsingConstructor(SimpleBean,"Ram",34){}
}
