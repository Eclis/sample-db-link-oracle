package sample.db.link.oracle

import grails.gorm.transactions.Transactional

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
}
