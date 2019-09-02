package sample.db.link.oracle

class TesteSG {

    Integer id
    Integer version
    String descricao

    static mapping = {
        table "TESTE_DB_LINK_SG"
        id generator:'assigned'
        version true
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
            //TesteODS.findAllByTesteSG(this)*.update(descricao)
            this.descricao = descricao
        }
    }

    void updateSemTX(String descricao) {
        //TesteODS.findAllByTesteSG(this)*.updateSemTX(descricao)
        this.descricao = descricao
        this.save(flush:true, failOnError:true)
        //executeUpdate("update TesteSG set descricao = $descricao where id = ${this.id}")
    }
}
