package levy.daniel.application.model.metier.commande;

import java.io.Serializable;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import levy.daniel.application.model.metier.client.AbstractClient;

/**
 * class AbstractCommande :<br/>
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
@Table(name = "ABSTRACT_COMMANDES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractCommande
		implements Serializable, Comparable<AbstractCommande>, Cloneable, ICommande {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	protected Long				id;

	/**
	 * dateCommande : DateTime :<br/>
	 * date de la commande.<br/>
	 */
	protected DateTime			dateCommande;

	/**
	 * montant : Double :<br/>
	 * montant de la commande.<br/>
	 */
	protected Double			montant;

	/**
	 * modePaiement : String :<br/>
	 * mode de paiement de la commande.<br/>
	 */
	protected String			modePaiement;

	/**
	 * statutPaiement : String :<br/>
	 * statut du paiement de la commande.<br/>
	 */
	protected String			statutPaiement;

	/**
	 * modeLivraison : String :<br/>
	 * mode de livraison de la commande.<br/>
	 */
	protected String			modeLivraison;

	/**
	 * statutLivraison : String :<br/>
	 * statut de la livraison de la commande.<br/>
	 */
	protected String			statutLivraison;

	/**
	 * client : AbstractClient :<br/>
	 * client de la commande.<br/>
	 */
	protected AbstractClient	client;

	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log	LOG					= LogFactory.getLog(AbstractCommande.class);

	// *************************METHODES************************************/

	/**
	 * method CONSTRUCTEUR AbstractCommande() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractCommande() {
		this(null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	/**
	 * method CONSTRUCTEUR AbstractCommande( CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pDateCommande : org.joda.time.DateTime : date de la commande.<br/>
	 * @param pMontant : Double : montant de la commande.<br/>
	 * @param pModePaiement : String : mode de paiement de la commande.<br/>
	 * @param pStatutPaiement : String : statut du paiement de la commande.<br/>
	 * @param pModeLivraison : String : mode de livraison de la commande.<br/>
	 * @param pStatutLivraison : String : statut de la livraison de la commande.<br/>
	 * @param pClient : AbstractClient : client de la commande.<br/>
	 */
	public AbstractCommande(final DateTime pDateCommande, final Double pMontant,
			final String pModePaiement, final String pStatutPaiement, final String pModeLivraison,
			final String pStatutLivraison, final AbstractClient pClient) {

		this(null, pDateCommande, pMontant, pModePaiement, pStatutPaiement, pModeLivraison,
				pStatutLivraison, pClient);

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	/**
	 * method CONSTRUCTEUR AbstractCommande( CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pDateCommande : org.joda.time.DateTime : date de la commande.<br/>
	 * @param pMontant : Double : montant de la commande.<br/>
	 * @param pModePaiement : String : mode de paiement de la commande.<br/>
	 * @param pStatutPaiement : String : statut du paiement de la commande.<br/>
	 * @param pModeLivraison : String : mode de livraison de la commande.<br/>
	 * @param pStatutLivraison : String : statut de la livraison de la commande.<br/>
	 * @param pClient : AbstractClient : client de la commande.<br/>
	 */
	public AbstractCommande(final Long pId, final DateTime pDateCommande, final Double pMontant,
			final String pModePaiement, final String pStatutPaiement, final String pModeLivraison,
			final String pStatutLivraison, final AbstractClient pClient) {

		super();

		id = pId;
		dateCommande = pDateCommande;
		montant = pMontant;
		modePaiement = pModePaiement;
		statutPaiement = pStatutPaiement;
		modeLivraison = pModeLivraison;
		statutLivraison = pStatutLivraison;
		client = pClient;

	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + (client == null ? 0 : client.hashCode());
		result = prime * result + (dateCommande == null ? 0 : dateCommande.hashCode());
		result = prime * result + (montant == null ? 0 : montant.hashCode());

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

		if (!(pObj instanceof AbstractCommande)) {
			return false;
		}

		final AbstractCommande other = (AbstractCommande) pObj;

		if (client == null) {
			if (other.client != null) {
				return false;
			}
		} else if (!client.equals(other.client)) {
			return false;
		}

		if (dateCommande == null) {
			if (other.dateCommande != null) {
				return false;
			}
		} else if (!dateCommande.equals(other.dateCommande)) {
			return false;
		}

		if (montant == null) {
			if (other.montant != null) {
				return false;
			}
		} else if (!montant.equals(other.montant)) {
			return false;
		}

		return true;

	} // Fin de equals().__________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final AbstractCommande pCommande) {

		if (this == pCommande) {
			return 0;
		}

		if (pCommande == null) {
			return -1;
		}

		int compareClient = 0;
		int compareDate = 0;
		int compareMontant = 0;

		/* client. */
		if (client == null) {
			if (pCommande.getClient() != null) {
				return +1;
			}
		} else {

			if (pCommande.getClient() == null) {
				return -1;
			}

			compareClient =
					getClient().getNom().compareToIgnoreCase(pCommande.getClient().getNom());

			if (compareClient != 0) {
				return compareClient;
			}
		}

		/* date. */
		if (getDateCommande() == null) {
			if (pCommande.getDateCommande() != null) {
				return +1;
			}
		} else {

			if (pCommande.getDateCommande() == null) {
				return -1;
			}

			compareDate = getDateCommande().compareTo(pCommande.getDateCommande());

			if (compareDate != 0) {
				return compareDate;
			}

		}

		/* montant. */
		if (getMontant() == null) {
			if (pCommande.getMontant() != null) {
				return +1;
			}

			return 0;
		}
		if (pCommande.getMontant() == null) {
			return -1;
		}

		compareMontant = getMontant().compareTo(pCommande.getMontant());

		return compareMontant;

	} // Fin de compareTo()._______________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractCommande clone() throws CloneNotSupportedException {

		final AbstractCommande commandeClone = (AbstractCommande) super.clone();

		commandeClone.setId(getId());
		commandeClone.setDateCommande(getDateCommande());
		commandeClone.setMontant(getMontant());
		commandeClone.setModePaiement(getModePaiement());
		commandeClone.setStatutPaiement(getStatutPaiement());
		commandeClone.setModeLivraison(getModeLivraison());
		commandeClone.setStatutLivraison(getStatutLivraison());

		AbstractClient clientClone = null;
		if (client != null) {
			clientClone = client.clone();
		}

		commandeClone.setClient(clientClone);

		return commandeClone;

	} // Fin de clone().___________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("AbstractCommande [");

		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (dateCommande != null) {
			builder.append("dateCommande=");
			builder.append(dateCommande);
			builder.append(", ");
		}
		if (montant != null) {
			builder.append("montant=");
			builder.append(montant);
			builder.append(", ");
		}
		if (modePaiement != null) {
			builder.append("modePaiement=");
			builder.append(modePaiement);
			builder.append(", ");
		}
		if (statutPaiement != null) {
			builder.append("statutPaiement=");
			builder.append(statutPaiement);
			builder.append(", ");
		}
		if (modeLivraison != null) {
			builder.append("modeLivraison=");
			builder.append(modeLivraison);
			builder.append(", ");
		}
		if (statutLivraison != null) {
			builder.append("statutLivraison=");
			builder.append(statutLivraison);
			builder.append(", ");
		}
		if (client != null) {
			builder.append("client=");
			builder.append(client.getNom());
			builder.append(' ');
			builder.append(client.getPrenom());
		}

		builder.append(']');

		return builder.toString();

	} // Fin de toString().________________________________________________

	/**
	 * {@inheritDoc} <br/>
	 * retourne "id;dateCommande;montant;modePaiement;statutPaiement;
	 * modeLivraison;statutLivraison;nomClient;prenomClient;"
	 */
	@Override
	public String getEnTeteCsv() {

		return "id;dateCommande;montant;modePaiement;statutPaiement;"
				+ "modeLivraison;statutLivraison;nomClient;prenomClient;";

	} // Fin de getEnTeteCsv().____________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {

		final StringBuilder builder = new StringBuilder();

		final String dateCommandeString = fournirDateFormatee(dateCommande);

		final String nomClient = fournirNomClient(client);
		final String prenomClient = fournirPrenomClient(client);

		builder.append(id);
		builder.append(';');

		builder.append(dateCommandeString);
		builder.append(';');

		builder.append(montant);
		builder.append(';');

		builder.append(modePaiement);
		builder.append(';');

		builder.append(statutPaiement);
		builder.append(';');

		builder.append(modeLivraison);
		builder.append(';');

		builder.append(statutLivraison);
		builder.append(';');

		builder.append(nomClient);
		builder.append(';');

		builder.append(prenomClient);
		builder.append(';');

		return builder.toString();

	} // Fin de toStringCsv()._____________________________________________

	/**
	 * {@inheritDoc} <br/>
	 * "id;dateCommande;montant;modePaiement;statutPaiement;
	 * modeLivraison;statutLivraison;nomClient;prenomClient;";
	 */
	@Override
	public String getEnTeteColonne(final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "dateCommande";
			break;

		case 2:
			entete = "montant";
			break;

		case 3:
			entete = "modePaiement";
			break;

		case 4:
			entete = "statutPaiement";
			break;

		case 5:
			entete = "modeLivraison";
			break;

		case 6:
			entete = "statutLivraison";
			break;

		case 7:
			entete = "nomClient";
			break;

		case 8:
			entete = "prenomClient";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne().________________________________________

	/**
	 * {@inheritDoc} <br/>
	 * "id;dateCommande;montant;modePaiement;statutPaiement;
	 * modeLivraison;statutLivraison;nomClient;prenomClient;";
	 */
	@Override
	public Object getValeurColonne(final int pI) {
		Object valeur = null;

		switch (pI) {

		case 0:
			valeur = id;
			break;

		case 1:
			valeur = fournirDateFormatee(dateCommande);
			break;

		case 2:
			valeur = montant;
			break;

		case 3:
			valeur = modePaiement;
			break;

		case 4:
			valeur = statutPaiement;
			break;

		case 5:
			valeur = modeLivraison;
			break;

		case 6:
			valeur = statutLivraison;
			break;

		case 7:
			valeur = fournirNomClient(client);
			break;

		case 8:
			valeur = fournirPrenomClient(client);
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne().________________________________________

	/**
	 * method fournirDateFormatee( DateTime pDate) :<br/>
	 * Retourne une date formatée au format "dd/MM/yyyy HH:mm:ss".<br/>
	 * Par exemple, 25/02/1961 14:37:35 <br/>
	 *
	 * @param pDate : org.joda.time.DateTime
	 * @return : String : date au format "dd/MM/yyyy HH:mm:ss".<br/>
	 */
	private String fournirDateFormatee(final DateTime pDate) {

		String dateFormatee = null;

		/* Récupération de la Locale courante de la machine. */
		final Locale localeFr = Locale.getDefault();

		/* Instanciation d'un DateTimeFormatter. */
		final DateTimeFormatter dtformatterComplet =
				DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss").withLocale(localeFr);

		/* Formatage de la org.joda.time.DateTime. */
		dateFormatee = pDate.toString(dtformatterComplet);

		return dateFormatee;

	} // Fin de fournirDateFormatee(...).__________________________________

	/**
	 * method fournirNomClient( AbstractClient pClient) :<br/>
	 * Retourne le nom d'un Client.<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient.<br/>
	 * @return : String : nom du Client.<br/>
	 */
	private String fournirNomClient(final AbstractClient pClient) {

		String nomClient = null;

		if (pClient != null) {
			nomClient = pClient.getNom();
		}

		return nomClient;

	} // Fin de fournirNomClient(...)._____________________________________

	/**
	 * method fournirPrenomClient( AbstractClient pClient) :<br/>
	 * Retourne le prénom d'un Client.<br/>
	 * <br/>
	 *
	 * @param pClient : AbstractClient.<br/>
	 * @return : String : prénom du Client.<br/>
	 */
	private String fournirPrenomClient(final AbstractClient pClient) {

		String prenomClient = null;

		if (pClient != null) {
			prenomClient = pClient.getPrenom();
		}

		return prenomClient;

	} // Fin de fournirPrenomClient(...).__________________________________

	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOMMANDE")
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
	} // Fin de setId().___________________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public DateTime getDateCommande() {
		return dateCommande;
	} // Fin de getDateCommande()._________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDateCommande(final DateTime pDateCommande) {
		dateCommande = pDateCommande;
	} // Fin de setDateCommande()._________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "MONTANT")
	@Override
	public Double getMontant() {
		return montant;
	} // Fin de getMontant().______________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMontant(final Double pMontant) {
		montant = pMontant;
	} // Fin de setMontant().______________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "MODE_DE_PAIEMENT")
	@Override
	public String getModePaiement() {
		return modePaiement;
	} // Fin de getModePaiement()._________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModePaiement(final String pModePaiement) {
		modePaiement = pModePaiement;
	} // Fin de setModePaiement()._________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "STATUT_PAIEMENT")
	@Override
	public String getStatutPaiement() {
		return statutPaiement;
	} // Fin de getStatutPaiement()._______________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStatutPaiement(final String pStatutPaiement) {
		statutPaiement = pStatutPaiement;
	} // Fin de setStatutPaiement()._______________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "MODE_LIVRAISON")
	@Override
	public String getModeLivraison() {
		return modeLivraison;
	} // Fin de getModeLivraison().________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModeLivraison(final String pModeLivraison) {
		modeLivraison = pModeLivraison;
	} // Fin de setModeLivraison().________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "STATUT_LIVRAISON")
	@Override
	public String getStatutLivraison() {
		return statutLivraison;
	} // Fin de getStatutLivraison().______________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStatutLivraison(final String pStatutLivraison) {
		statutLivraison = pStatutLivraison;
	} // Fin de setStatutLivraison().______________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	@ManyToOne()
	@JoinColumn(name = "IDCLIENT")
	public AbstractClient getClient() {
		return client;
	} // Fin de getClient()._______________________________________________

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setClient(final AbstractClient pClient) {
		client = pClient;
	} // Fin de setClient()._______________________________________________

} // FIN DE LA CLASSE AbstractCommande.--------------------------------------
