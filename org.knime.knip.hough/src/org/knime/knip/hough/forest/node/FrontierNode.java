/*
 * ------------------------------------------------------------------------
 *
 *  Copyright (C) 2003 - 2017
 *  University of Konstanz, Germany and
 *  KNIME GmbH, Konstanz, Germany
 *  Website: http://www.knime.org; Email: contact@knime.org
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License, Version 3, as
 *  published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 *  Additional permission under GNU GPL version 3 section 7:
 *
 *  KNIME interoperates with ECLIPSE solely via ECLIPSE's plug-in APIs.
 *  Hence, KNIME and ECLIPSE are both independent programs and are not
 *  derived from each other. Should, however, the interpretation of the
 *  GNU GPL Version 3 ("License") under any applicable laws result in
 *  KNIME and ECLIPSE being a combined program, KNIME GMBH herewith grants
 *  you the additional permission to use and propagate KNIME together with
 *  ECLIPSE with only the license terms in place for ECLIPSE applying to
 *  ECLIPSE and the GNU GPL Version 3 applying for KNIME, provided the
 *  license terms of ECLIPSE themselves allow for the respective use and
 *  propagation of ECLIPSE together with KNIME.
 *
 *  Additional permission relating to nodes for KNIME that extend the Node
 *  Extension (and in particular that are based on subclasses of NodeModel,
 *  NodeDialog, and NodeView) and that only interoperate with KNIME through
 *  standard APIs ("Nodes"):
 *  Nodes are deemed to be separate and independent programs and to not be
 *  covered works.  Notwithstanding anything to the contrary in the
 *  License, the License does not apply to Nodes, you are not required to
 *  license Nodes under the License, and you are granted a license to
 *  prepare and propagate Nodes, in each case even if such Nodes are
 *  propagated with or for interoperation with KNIME.  The owner of a Node
 *  may freely choose the license terms applicable to such Node, including
 *  when such Node is propagated with or for interoperation with KNIME.
 * --------------------------------------------------------------------- *
 *
 */
package org.knime.knip.hough.forest.node;

import org.knime.knip.hough.forest.training.SampleTrainingObject;

import net.imglib2.type.numeric.RealType;

/**
 * Represents a frontier node of a Hough tree which needs to be replaced during a breadth first learning.
 * 
 * @author Simon Schmid, University of Konstanz
 */
public final class FrontierNode<T extends RealType<T>> extends Node {

	private final SampleTrainingObject<T> m_sampledTrainingObjects;
	private final SampleTrainingObject<T> m_allTrainingObjects;
	private final long m_seed;
	private final boolean m_isLeftChild;

	/**
	 * Creates an object of this class with all relevant parameters.
	 * 
	 * @param sampledTrainingObjects the {@link SampleTrainingObject}
	 * @param allTrainingObjects the {@link SampleTrainingObject}
	 * @param // TODO complete doc for this class
	 * @param classProbabilities the class probabilities
	 * @param depth depth of the node
	 */
	public FrontierNode(final SampleTrainingObject<T> sampledTrainingObjects,
			final SampleTrainingObject<T> allTrainingObjects, final int depth, final int nodeIdx,
			final SplitNode parent, final boolean isLeftChild, final double[] classProbabilities, final long seed) {
		super(depth, nodeIdx, classProbabilities, sampledTrainingObjects.getOffsets(), parent);
		m_sampledTrainingObjects = sampledTrainingObjects;
		m_allTrainingObjects = allTrainingObjects;
		m_seed = seed;
		m_isLeftChild = isLeftChild;
	}

	/**
	 * @return the sample
	 */
	public SampleTrainingObject<T> getSampledTrainingObjects() {
		return m_sampledTrainingObjects;
	}

	/**
	 * @return the seed
	 */
	public long getSeed() {
		return m_seed;
	}

	/**
	 * @return the isLeftChild
	 */
	public boolean isLeftChild() {
		return m_isLeftChild;
	}

	/**
	 * @return the allTrainingObjects
	 */
	public SampleTrainingObject<T> getAllTrainingObjects() {
		return m_allTrainingObjects;
	}

}
