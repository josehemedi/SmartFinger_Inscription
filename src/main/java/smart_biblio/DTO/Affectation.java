package smart_biblio.DTO;

public class Affectation {
    private Long id;
    private Long idEquipement;
    private Long idSalle;

    public Affectation(Long id,Long idEquipement,Long idSalle){
        this.id=id;
        this.idEquipement=idEquipement;
        this.idSalle=idSalle;
        
 }
}

