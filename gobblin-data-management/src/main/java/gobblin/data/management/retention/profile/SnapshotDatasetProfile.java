/*
 * Copyright (C) 2014-2016 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 */

package gobblin.data.management.retention.profile;

import java.io.IOException;
import java.util.Properties;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import gobblin.data.management.retention.dataset.SnapshotDataset;
import gobblin.dataset.Dataset;


/**
 * {@link gobblin.dataset.DatasetsFinder} for snapshot datasets.
 *
 * <p>
 *   Snapshot datasets are datasets where each version is a snapshot/full-dump of a dataset (e.g. a database).
 * </p>
 */
public class SnapshotDatasetProfile extends ConfigurableGlobDatasetFinder<Dataset> {

  public SnapshotDatasetProfile(FileSystem fs, Properties props) {
    super(fs, props);
  }

  @Override
  public Dataset datasetAtPath(Path path) throws IOException {
    return new SnapshotDataset(this.fs, this.props, path);
  }

}
