/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.training.space.gradebook.postprocessor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexerPostProcessor;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.training.space.gradebook.model.Assignment;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.Log;

import java.util.LinkedHashMap;
import java.util.Locale;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
	"indexer.class.name=com.liferay.training.space.gradebook.model.Assignment"
    },
    service = IndexerPostProcessor.class
)
public class GradebookIndexerPostProcessor implements IndexerPostProcessor {

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter booleanFilter, SearchContext searchContext)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("postProcessContextBooleanFilter");
		}
	}

	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("postProcessContextQuery");
		}
	}

	@Override
	public void postProcessDocument(Document document, Object obj)
		throws Exception {

		Assignment assignment = (Assignment) obj;

		long assignmentId = assignment.getPrimaryKey();

		document.addNumber("assignmentId", assignmentId);
	}

	@Override
	public void postProcessFullQuery(
			BooleanQuery fullQuery, SearchContext searchContext)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("postProcessFullQuery");
		}
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter booleanFilter,
			SearchContext searchContext)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("postProcessSearchQuery");
		}
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		LinkedHashMap<String, Object> params = (LinkedHashMap<String, Object>)
				searchContext.getAttribute("params");

		if (params != null) {
			long assignmentId = (long) params.get("assignmentId");

			searchQuery.addRequiredTerm("assignmentId", assignmentId);
		}

		if (_log.isInfoEnabled()) {
			_log.info("postProcessSearchQuery");
		}
		
	}

	@Override
	public void postProcessSummary(
		Summary summary, Document document, Locale locale, String snippet) {

		if (_log.isInfoEnabled()) {
			_log.info("postProcessSummary");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		GradebookIndexerPostProcessor.class);

}