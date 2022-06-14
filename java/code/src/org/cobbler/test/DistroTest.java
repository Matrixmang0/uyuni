/*
 * Copyright (c) 2009--2014 Red Hat, Inc.
 *
 * This software is licensed to you under the GNU General Public License,
 * version 2 (GPLv2). There is NO WARRANTY for this software, express or
 * implied, including the implied warranties of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. You should have received a copy of GPLv2
 * along with this software; if not, see
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.txt.
 *
 * Red Hat trademarks are not licensed under GPLv2. No permission is
 * granted to use or replicate Red Hat trademarks that are incorporated
 * in this software or its documentation.
 */

package org.cobbler.test;

import org.cobbler.CobblerConnection;
import org.cobbler.Distro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author paji
 */
public class DistroTest {
    private CobblerConnection client;
    private Distro testDistro;

    @BeforeEach
    public void setUp() throws Exception {
        MockConnection.clear();
        client = new MockConnection("http://localhost", "token");
        String distroName = "testDistro";
        testDistro = new Distro.Builder().setName(distroName).build(client);
    }

    @AfterEach
    public void teardown() {
        testDistro = null;
        MockConnection.clear();
    }

    @Test
    public void testDistroBuilder() {
        // Arrange
        String name = "Partha-Test";
        String kernel =
                "/var/satellite/rhn/kickstart/ks-rhel-i386-as-4-u2//images/pxeboot/vmlinuz";
        String initrd =
                "/var/satellite/rhn/kickstart/ks-rhel-i386-as-4-u2//images/pxeboot/initrd.img";
        String breed = "redhat";
        String osVersion = "rhel4";
        String arch = "i386";

        // Act
        Distro newDistro = new Distro.Builder()
                .setName(name)
                .setKernel(kernel)
                .setInitrd(initrd)
                .setKsmeta(Optional.empty())
                .setBreed(breed)
                .setOsVersion(osVersion)
                .setArch(arch)
                .build(client);

        // Assert
        Assertions.assertEquals(name, newDistro.getName());
        Assertions.assertEquals(kernel, newDistro.getKernel());
        Assertions.assertEquals(initrd, newDistro.getInitrd());
    }

    @Test
    public void testOwnersRaw() {
        // Arrange
        Optional<List<String>> expectedRaw = Optional.of(Arrays.asList("test1", "test2"));

        // Act
        testDistro.setOwners(expectedRaw);
        Optional<List<String>> resultRaw = testDistro.getOwners();

        // Assert
        Assertions.assertEquals(expectedRaw, resultRaw);
    }

    @Test
    public void testOwnersResolved() {
        // Arrange
        List<String> expectedResolved = Arrays.asList("test1", "test2");

        // Act
        testDistro.setResolvedOwners(expectedResolved);
        List<String> resultResolved = testDistro.getResolvedOwners();

        // Assert
        Assertions.assertEquals(expectedResolved, resultResolved);
    }

    @Test
    public void testKernelOptions() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testKernelOptionsPost() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testAutoinstallMeta() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testRedhatManagementKey() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testComment() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testManagementClasses() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testUid() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testName() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testCreated() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testModified() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testDepth() {
        // TODO
        Assertions.fail("Not implemented");
    }

    @Test
    public void testParent() {
        // TODO
        Assertions.fail("Not implemented");
    }
}
