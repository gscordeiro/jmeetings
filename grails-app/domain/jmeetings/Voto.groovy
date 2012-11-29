package jmeetings

class Voto {

	static belongsTo = [inscricao:Inscricao, opcao:Opcao]
	
	Date data = new Date()
	
	String toString(){
		"${inscricao.participante} votando em ${opcao}"
	}
	
	def static buscaVotoNaMesmaEnquete(inscricao, enquete){
		Voto.find('from Voto where inscricao = :inscricao and opcao.enquete = :enquete', [inscricao:inscricao, enquete:enquete])
	}
	
    static constraints = {
		//como validar o objeto inteiro? isso não tem a ver com a propriedade 'opcao'
		opcao validator: {val, obj, errors ->
			
			def voto = Voto.buscaVotoNaMesmaEnquete(obj.inscricao, obj.opcao.enquete)
			
			if(voto){
				errors.reject("voto.invalido", "Você já votou nessa enquete")
				return false
			}
			
			return true
		}
    }
	
}
