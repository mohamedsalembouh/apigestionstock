package com.salem.gestionstock.exceptions;

public enum ErrorCodes {

    ARTICLE_NOT_FOUND,
    CATEGORIE_NOT_FOUND,
    CLIENT_NOT_FOUND,
    COMMANDE_CLIENT_NOT_FOUNDE,
    COMMANDE_FOURNISSEUR_NOT_FOUND,
    ENTREPRISE_NOT_FOUND,
    FOURNISSEUR_NOUT_FOUND,
    LIGNE_COMMANDE_CLIENT_NOT_FOUND,
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND,
    LIGNE_VENTE_NOT_FOUND,
    MVT_STK_NOT_FOUND,
    UTILISATEUR_NOT_FOUND,
    VENTES_NOT_FOUND,
    ;

    private Integer code;
  void  ErrorCode(Integer code){
        this.code = code;
    }

    public int getCode(){
      return code;
    }
}
