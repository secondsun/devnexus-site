/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.devnexus.ting.core.dao.jaxb;

import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Repository;

import com.devnexus.ting.core.dao.BackupDao;
import com.devnexus.ting.core.model.Backup;

/**
 * @author Gunnar Hillert
 * @since 2.0
 *
 */
@Repository("backupDao")
public class BackupDaoJaxb implements BackupDao {

    /** Logger declaration */
    private static final Logger LOGGER = LoggerFactory.getLogger(BackupDaoJaxb.class);

    private @Autowired Jaxb2Marshaller marshaller;

    /**
     *
     */
    public BackupDaoJaxb() {
    }

    @Override
    public Backup convertToBackupData(final InputStream inputStream) {

        final StreamSource source = new StreamSource(inputStream);
        final Backup backup = (Backup) marshaller.unmarshal(source);

        LOGGER.info("Restoring: " + backup.getUsers().size()         + " users, "
                                  + backup.getEvents().size()        + " events, "
                                  + backup.getOrganizers().size()    + " organizers, "
                                  + backup.getPresentations().size() + " presentations, and "
                                  + backup.getSpeakers().size()      + " speakers.");

        return backup;

    }

}
