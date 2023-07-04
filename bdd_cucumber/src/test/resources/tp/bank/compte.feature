Feature: CompteBancaire bien géré
  Gestion de compte bancaire (debiter, crediter)

  Scenario Outline: Decouvert autorisé ou pas
    Given soldeInitial=<soldeInitial>
    When debiter montant=<montant>
    Then nouveauSolde=<nouveauSolde>
    And statut="<statut>"
    And AvecException=<AvecException>

  Examples:
    | soldeInitial | montant | nouveauSolde | statut      |AvecException |
    | 100          | 200     | -100         | A_DECOUVERT |false         |   
    | 400          | 300     | 100          | OK          |false         |
    | 100          | 500     | 100          | OK          |true          |
    | -100         | 400     | -100         | A_DECOUVERT |true          |
 