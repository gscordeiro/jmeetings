package jmeetings

class Opcao {

	static belongsTo = [enquete:Enquete]
	
	String descricao
	
	String toString(){
		descricao
	}
	
    static constraints = {
    }
}
