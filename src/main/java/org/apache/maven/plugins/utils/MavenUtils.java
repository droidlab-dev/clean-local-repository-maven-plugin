package org.apache.maven.plugins.utils;

/*
 * Copyright 2013 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0,
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

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * This utility class provides basic operations on maven artifacts
 * 
 * @author sgu, pef, lab...
 */
public final class MavenUtils {

	
	/**
	 * Private constructor prevent the class from being explicitly instantiated
	 */
	private MavenUtils() 
	{
		super();
	}
	
	
	/**
	 * Get all the snapshot artifact of a given directory
	 * 
	 * @param artifactFolders
	 * @return the list of snapshot artifacts contained by the given directory
	 */
	public static List<File> getSnapshots(final List<File> artifactFolders) {

		final List<File> result = new LinkedList<File>();
		
		for (final File file : artifactFolders) {
			
			if(isSnapshotFolder(file)){
				result.add(file);
			}
		}
		
		return result;
	}
	
	/**
	 * Get all the release artifact of a given directory
	 * 
	 * @param artifactFolders
	 * @return the list of release artifacts contained by the given directory
	 */
	public static List<File> getReleases(final List<File> artifactFolders) {

		final List<File> result = new LinkedList<File>();
		
		for (File file : artifactFolders) {
			
			if(!isSnapshotFolder(file)){
				result.add(file);
			}
		}
		
		return result;
	}
	
	
	/**
	 * Define if the given file is a snapshot artifact.
	 * 
	 * @param artifactFolder
	 * @return true if the given file is a snapshot artifact, false otherwise.
	 */
	private static boolean isSnapshotFolder(final File artifactFolder) {
		
		final String path = artifactFolder.getAbsolutePath();
		
		return path.contains("SNAPSHOT") || path.contains("snapshot");
		
	}
}
