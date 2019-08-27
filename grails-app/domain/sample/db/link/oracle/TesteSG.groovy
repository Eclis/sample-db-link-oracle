package sample.db.link.oracle

class TesteSG {

    Integer id
    String descricao

    static mapping = {
        table "TESTE_DB_LINK_SG"
        id generator:'assigned'
        version false
    }

    static TesteSG criar(Integer id, String descricao) {
        new TesteSG().with {
            it.id = id
            it.descricao = descricao
            it.save()
        }
    }

    def update(String descricao) {
        withTransaction {
            TesteODS.findAllByTesteSG(this)*.update(descricao)
            this.descricao = descricao
        }
    }
}
