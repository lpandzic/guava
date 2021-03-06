/*
 * Copyright (C) 2014 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

import java.util.Set;

/**
 * A subinterface of {@code Graph} for graphs whose edges are all directed.
 *
 * @author Joshua O'Madadhain
 * @param <N> Node parameter type
 * @param <E> Edge parameter type
 * @since 20.0
 */
@Beta
public interface DirectedGraph<N, E> extends Graph<N, E> {
  /**
   * Returns the node for which {@code edge} is an outgoing edge.
   *
   * @throws IllegalArgumentException if {@code edge} is not an element of this graph
   */
  N source(Object edge);

  /**
   * Returns the node for which {@code edge} is an incoming edge.
   *
   * @throws IllegalArgumentException if {@code edge} is not an element of this graph
   */
  N target(Object edge);

  /**
   * {@inheritDoc}
   *
   * <p>If {@code edge} is not a self-loop, the iteration order will be
   * {@code [source(edge), target(edge)]}.
   *
   */
  @Override
  Set<N> incidentNodes(Object edge);

  /**
   * {@inheritDoc}
   *
   * <p>The {@linkplain #source(Object) source} and {@linkplain #target(Object) target}
   * of the edges returned must be {@code source} and {@code target}, respectively.
   *
   */
  @Override
  Set<E> edgesConnecting(Object source, Object target);

  /**
   * {@inheritDoc}
   *
   * <p>{@code edge} is an outgoing edge of {@code source} and an incoming edge of {@code target}.
   */
  @Override
  @CanIgnoreReturnValue
  boolean addEdge(E edge, N source, N target);
}
