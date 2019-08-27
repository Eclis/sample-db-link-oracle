package sample.db.link.oracle

import grails.converters.JSON

class TesteController {

    def testeService

    def create(Integer id, String descricao) {
        render testeService.criar(id, descricao) as JSON
    }

    def list(Integer id) {
        def map = [:]
        map["SG"] = TesteSG.get(id)
        map["ODS"] = TesteODS.get(id)

        render map as JSON
    }

    def update (Integer id, String descricao) {
        render testeService.update(id, descricao) as JSON
    }

    def updateSemDDD(Integer id, String descricao) {
        render testeService.updateSemDDD(id, descricao) as JSON
    }

    def updateSemTX(Integer id, String descricao) {
        render testeService.updateSemTX(id, descricao) as JSON
    }
}
