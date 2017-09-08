package levy.daniel.application.model.metier.client;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.commande.AbstractCommande;

/**
 * class AbstractClient :<br/>
 * .<br/>
 * <br/>
 * - Exemple d'utilisation :<br/>
 * <br/>
 * - Mots-clé :<br/>
 * <br/>
 * - Dépendances :<br/>
 * <br/>
 *
 * @author dan Lévy
 * @version 1.0
 * @since 20 août 2017
 */
@Entity
@Table(name = "ABSTRACT_CLIENTS")
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractClient
		implements Serializable, Comparable<AbstractClient>, Cloneable, IClient {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long		serialVersionUID	= 1L;

	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	@Column(name = "IDCLIENT")
	protected Long					id;

	/**
	 * nom : String :<br/>
	 * Nom du client.<br/>
	 */
	protected String				nom;

	/**
	 * prenom : String :<br/>
	 * Prénom du client.<br/>
	 */
	protected String				prenom;

	/**
	 * adresseLivraison : String :<br/>
	 * adresse de livraison du client.<br/>
	 */
	protected String				adresseLivraison;

	/**
	 * telephone : String :<br/>
	 * Numéro de téléphone du client.<br/>
	 */
	protected String				telephone;

	/**
	 * email : String :<br/>
	 * email du client.<br/>
	 */
	protected String				email;

	/**
	 * commandes.
	 */
	private List<AbstractCommande>	commandes;

	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log		LOG					= LogFactory.getLog(AbstractClient.class);

	// *************************METHODES************************************/

	/**
	 * method CONSTRUCTEUR AbstractClient() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractClient() {
		this(null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	/**
	 * method CONSTRUCTEUR AbstractClient( CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pNom : String : Nom du client.<br/>
	 * @param pPrenom : String : Prénom du client.<br/>
	 * @param pAdresseLivraison : String : adresse de livraison du client.<br/>
	 * @param pTelephone : String : Numéro de téléphone du client.<br/>
	 * @param pEmail : String : email du client.<br/>
	 */
	public AbstractClient(final String pNom, final String pPrenom, final String pAdresseLivraison,
			final String pTelephone, final String pEmail) {

		this(null, pNom, pPrenom, pAdresseLivraison, pTelephone, pEmail);

	} // Fin du CONSTRUCTEUR COMPLET.______________________________________

	/**
	 * method CONSTRUCTEUR AbstractClient( CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pNom : String : Nom du client.<br/>
	 * @param pPrenom : String : Prénom du client.<br/>
	 * @param pAdresseLivraison : String : adresse de livraison du client.<br/>
	 * @param pTelephone : String : Numéro de téléphone du client.<br/>
	 * @param pEmail : String : email du client.<br/>
	 */
	public AbstractClient(final Long pId, final String pNom, final String pPrenom,
			final String pAdresseLivraison, final String pTelephone, final String pEmail) {

		super();

		id = pId;
		nom = pNom;
		prenom = pPrenom;
		adresseLivraison = pAdresseLivraison;
		telephone = pTelephone;
		email = pEmail;

	} // Fin du CONSTRUCTEUR COMPLET BASE._________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + (nom == null ? 0 : nom.hashCode());
		result = prime * result + (prenom == null ? 0 : prenom.hashCode());
		result = prime * result + (email == null ? 0 : email.hashCode());

		return result;

	} // Fin de hashCode().________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object pObj) {

		if (this == pObj) {
			return true;
		}

		if (pObj == null) {
			return false;
		}

		if (!(pObj instanceof AbstractClient)) {
			return false;
		}

		final AbstractClient other = (AbstractClient) pObj;

		/* nom. */
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}

		/* prenom. */
		if (prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!prenom.equals(other.prenom)) {
			return false;
		}

		/* email. */
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}

		return true;

	} // Fin de equals().__________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final AbstractClient pClient) {

		if (this == pClient) {
			return 0;
		}

		if (pClient == null) {
			return -1;
		}

		int compareNom = 0;
		int comparePrenom = 0;
		int compareEmail = 0;

		/* nom. */
		if (getNom() == null) {
			if (pClient.getNom() != null) {
				return +1;
			}
		} else {
			if (pClient.getNom() == null) {
				return -1;
			}

			compareNom = getNom().compareToIgnoreCase(pClient.getNom());

			if (compareNom != 0) {
				return compareNom;
			}
		}

		/* prenom. */
		if (getPrenom() == null) {
			if (pClient.getPrenom() != null) {
				return +1;
			}
		} else {
			if (pClient.getPrenom() == null) {
				return -1;
			}

			comparePrenom = getPrenom().compareToIgnoreCase(pClient.getPrenom());

			if (comparePrenom != 0) {
				return comparePrenom;
			}
		}

		/* email. */
		if (getEmail() == null) {
			if (pClient.getEmail() != null) {
				return +1;
			}

			return 0;
		}

		if (pClient.getEmail() == null) {
			return -1;
		}

		compareEmail = getEmail().compareToIgnoreCase(pClient.getEmail());

		return compareEmail;

	} // Fin de compareTo(...).____________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractClient clone() throws CloneNotSupportedException {

		final AbstractClient clientClone = (AbstractClient) super.clone();

		clientClone.setId(getId());
		clientClone.setPrenom(getPrenom());
		clientClone.setNom(getNom());
		clientClone.setAdresseLivraison(getAdresseLivraison());
		clientClone.setTelephone(getTelephone());
		clientClone.setEmail(getEmail());

		return clientClone;

	} // Fin de clone().___________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("AbstractClient [");

		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (nom != null) {
			builder.append("nom=");
			builder.append(nom);
			builder.append(", ");
		}
		if (prenom != null) {
			builder.append("prenom=");
			builder.append(prenom);
			builder.append(", ");
		}
		if (adresseLivraison != null) {
			builder.append("adresseLivraison=");
			builder.append(adresseLivraison);
			builder.append(", ");
		}
		if (telephone != null) {
			builder.append("telephone=");
			builder.append(telephone);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
		}

		builder.append(']');

		return builder.toString();

	} // Fin de toString().________________________________________________

	/**
	 * {@inheritDoc} <br/>
	 * retourne "id;nom;prenom;adresse;telephone;email;"
	 */
	@Override
	public String getEnTeteCsv() {
		return "id;nom;prenom;adresse;telephone;email;";
	} // Fin de getEnTeteCsv().____________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {

		final StringBuilder builder = new StringBuilder();

		builder.append(id);
		builder.append(';');
		builder.append(nom);
		builder.append(';');
		builder.append(prenom);
		builder.append(';');
		builder.append(adresseLivraison);
		builder.append(';');
		builder.append(telephone);
		builder.append(';');
		builder.append(email);
		builder.append(';');

		return builder.toString();

	} // Fin de toStringCsv()._____________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEnTeteColonne(final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "nom";
			break;

		case 2:
			entete = "prénom";
			break;

		case 3:
			entete = "adresse";
			break;

		case 4:
			entete = "telephone";
			break;

		case 5:
			entete = "email";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValeurColonne(final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			valeur = id;
			break;

		case 1:
			valeur = nom;
			break;

		case 2:
			valeur = prenom;
			break;

		case 3:
			valeur = adresseLivraison;
			break;

		case 4:
			valeur = telephone;
			break;

		case 5:
			valeur = email;
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________

	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Override
	public Long getId() {
		return id;
	} // Fin de getId().___________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(final Long pId) {
		id = pId;
	} // Fin de setId(...).________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "NOM")
	@Override
	public String getNom() {
		return nom;
	} // Fin de getNom().__________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(final String pNom) {
		nom = pNom;
	} // Fin de setNom(...)._______________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "PRENOM")
	@Override
	public String getPrenom() {
		return prenom;
	} // Fin de getPrenom()._______________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrenom(final String pPrenom) {
		prenom = pPrenom;
	} // Fin de setPrenom(...).____________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "ADRESSE")
	@Override
	public String getAdresseLivraison() {
		return adresseLivraison;
	} // Fin de getAdresseLivraison()._____________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAdresseLivraison(final String pAdresseLivraison) {
		adresseLivraison = pAdresseLivraison;
	} // Fin de setAdresseLivraison(...).__________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "TELEPHONE")
	@Override
	public String getTelephone() {
		return telephone;
	} // Fin de getTelephone().____________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTelephone(final String pTelephone) {
		telephone = pTelephone;
	} // Fin de setTelephone(...)._________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "EMAIL")
	@Override
	public String getEmail() {
		return email;
	} // Fin de getEmail().________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEmail(final String pEmail) {
		email = pEmail;
	} // Fin de setEmail(...)._____________________________________________

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOMMANDE")
	public List<AbstractCommande> getCommandes() {
		return commandes;
	}

	@Override
	public void setCommandes(List<AbstractCommande> commandes) {
		this.commandes = commandes;
	}

} // FIN DE LA CLASSE AbstractClient.----------------------------------------
