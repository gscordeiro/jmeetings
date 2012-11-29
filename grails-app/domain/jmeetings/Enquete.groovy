package jmeetings

class Enquete {

	
	static hasMany = [opcoes:Opcao]
	static belongsTo = [evento:Evento]
	
	String descricao
	Boolean publica = false
	
	String toString(){
		descricao
	}
	
    static constraints = {
    }
}
