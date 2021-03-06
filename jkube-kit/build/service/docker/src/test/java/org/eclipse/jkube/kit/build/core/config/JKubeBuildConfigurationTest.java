/**
 * Copyright (c) 2019 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at:
 *
 *     https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.jkube.kit.build.core.config;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JKubeBuildConfigurationTest {

    @Test
    public void testBuilder(@Mocked JKubeAssemblyConfiguration mockJKubeAssemblyConfiguration) {
        // Given
        new Expectations() {{
            mockJKubeAssemblyConfiguration.getName();
            result = "1337";
        }};
        // When
        final JKubeBuildConfiguration result = new JKubeBuildConfiguration.Builder()
                .assembly(mockJKubeAssemblyConfiguration)
                .user("super-user")
                .build();
        // Then
        assertThat(result.getUser(), equalTo("super-user"));
        assertThat(result.getAssemblyConfiguration().getName(), equalTo("1337"));
    }
}
