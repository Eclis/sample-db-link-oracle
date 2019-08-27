package sample.db.link.oracle

class TesteODS {

    Integer id
    String descricao
    TesteSG testeSG

    static mapping = {
        table "TESTE_DB_LINK_ODS@ODS"
        id generator:'assigned'
        testeSG column: "testeSGId"
        version false
    }

    static TesteODS criar(Integer id, TesteSG testeSG) {
        new TesteODS().with {
            it.id = id
            it.descricao = testeSG.descricao
            it.testeSG = testeSG
            it.save()
        }
    }

    def update(String descricao) {
        withTransaction {
            this.descricao = descricao
        }
    }

    def updateSemTX(String descricao) {
        this.descricao = descricao
    }
}
