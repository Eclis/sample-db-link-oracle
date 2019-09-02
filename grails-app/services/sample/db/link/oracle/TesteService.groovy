package sample.db.link.oracle

import grails.gorm.transactions.Transactional

//import grails.gorm.transactions.Transactional
//
@Transactional
class TesteService {

    def criar(Integer id, String descricao) {
        def map = [:]
        def testeSG = TesteSG.criar(id, descricao)
        map["criou SG"] = testeSG
        map["criou ODS"] = TesteODS.criar(id, testeSG)
        map
    }

    def update(Integer id, String descricao) {
        def map = [:]
        TesteSG.get(id).update(descricao)
        map["updeitou SG"] = TesteSG.get(id)
        map["updeitou ODS"] = TesteODS.get(id)
        map
    }

    def updateSemDDD(Integer id, String descricao) {
        def map = [:]
        TesteSG.get(id).with {
            it.descricao = descricao
//            TesteODS.findAllByTesteSG(it)*.with {
//                it.descricao = descricao
//            }
        }
        map["updeitou SG"] = TesteSG.get(id)
        map["updeitou ODS"] = TesteODS.get(id)
        map
    }

    def updateSemTX(Integer id, String descricao) {
        def map = [:]
        def teste = TesteSG.get(id)
        teste.updateSemTX(descricao)
        map["updeitou SG"] = teste
        map
    }

    def douglasUpdate() {
        TesteSG.get(2).updateSemTX("jovempadawan")
    }

    def bolsonaroUpdate() {
        TesteSG.get(2).descricao = "putaqpariu"
    }
}
