package org.jboss.narayana.compensations.cdi;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.jbossts.xts.bytemanSupport.participantCompletion.ParticipantCompletionCoordinatorRules;
import org.jboss.narayana.compensations.cdi.common.DummyCompensationHandler1;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

/**
 * @author paul.robinson@redhat.com 29/04/2014
 */
@RunWith(Arquillian.class)
public class BasicTestLocal extends BasicTest {

    @Deployment
    public static WebArchive createTestArchive() {

        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(BasicTestLocal.class.getPackage())
                .addPackage(DummyCompensationHandler1.class.getPackage())
                .addClass(ParticipantCompletionCoordinatorRules.class)
                .addAsManifestResource("services/javax.enterprise.inject.spi.Extension")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");


        archive.delete(ArchivePaths.create("META-INF/MANIFEST.MF"));

        final String ManifestMF = "Manifest-Version: 1.0\n"
                + "Dependencies: org.jboss.narayana.compensations,org.jboss.xts\n";
        archive.setManifest(new StringAsset(ManifestMF));

        return archive;
    }
}
