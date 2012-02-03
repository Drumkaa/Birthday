package fr.epsi;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.*;

public class TestsServiceSouhaitAnniversaire {

    @Before
    public void setUp() throws Exception {
        stubEntrepôtEnployé = mock(EntrepôtEnployé.class);
        envoyeurDeMail = mock(EnvoyeurDeMail.class);
        serviceSouhaitAnniversaire = new ServiceSouhaitAnniversaire(envoyeurDeMail, stubEntrepôtEnployé);
    }

    @Test
    public void nEnvoiePasDeMailsSiPasDEmployés() {
        when(stubEntrepôtEnployé.tous()).thenReturn(Lists.<Employé>newArrayList());
        
        serviceSouhaitAnniversaire.souhaiteAnniversaire();

        verifyZeroInteractions(envoyeurDeMail);
    }

    @Test
    public void peutEnvoyerUnMailSiAnniversaire() {
        when(stubEntrepôtEnployé.tous()).thenReturn(Lists.newArrayList(employéAvecAnniversaire()));

        serviceSouhaitAnniversaire.souhaiteAnniversaire();

        verify(envoyeurDeMail).envoi();
    }

    private Employé employéAvecAnniversaire() {
        return new Employé(new Date());
    }

    private EntrepôtEnployé stubEntrepôtEnployé;
    private EnvoyeurDeMail envoyeurDeMail;
    private ServiceSouhaitAnniversaire serviceSouhaitAnniversaire;
}
