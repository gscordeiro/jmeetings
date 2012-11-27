package jmeetings



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(InscricaoController)
@Mock([Participante, Inscricao, Evento])
class InscricaoControllerTests {

    void testInscricaoSimples() {
       params["participante.nome"] = "Gilliard"
	   params["participante.email"] = "gscordeiro@gmail.com"
	   
	   new Evento(nome: 'Javaneiros', email: 'coordenacao@jugms.com.br').save()
	   
	   assert Evento.count() == 1
	   
	   controller.inscricaoSimples()
	   
	   assert Inscricao.count() == 1
	   
	   assert Inscricao.get(1).participante.email == "gscordeiro@gmail.com"
    }
}
