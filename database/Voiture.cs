namespace com.plaquesolaire.entity.infrastructure;

//[using]

[Table(name = "voiture")]
class Voiture
{

    [Column("plaque")]
    public String plaque { get; set;};

    [Column("marque")]
    public String marque { get; set;};


}
