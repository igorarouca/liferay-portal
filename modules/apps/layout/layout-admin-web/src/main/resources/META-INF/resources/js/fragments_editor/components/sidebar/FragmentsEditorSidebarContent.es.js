import Component from 'metal-component';
import {Config} from 'metal-state';
import Soy from 'metal-soy';

import './fragments/SidebarSectionsSection.es';
import './layouts/SidebarLayoutsSection.es';
import templates from './FragmentsEditorSidebarContent.soy';

/**
 * FragmentsEditorSidebarContent
 * @review
 */
class FragmentsEditorSidebarContent extends Component {

	/**
	 * Updates active section
	 * @param {!MouseEvent} event
	 * @private
	 * @review
	 */
	_handleSectionButtonClick(event) {
		this._sectionId = event.delegateTarget.dataset.sectionId;
	}
}

/**
 * State definition.
 * @review
 * @static
 * @type {!Object}
 */
FragmentsEditorSidebarContent.STATE = {

	/**
	 * Sidebar sections
	 * @default []
	 * @memberof FragmentsEditorSidebarContent
	 * @private
	 * @review
	 * @type {object}
	 */
	_sections: Config
		.arrayOf(
			Config.shapeOf(
				{
					icon: Config.string(),
					label: Config.string(),
					sectionId: Config.string()
				}
			)
		)
		.internal()
		.value(
			[
				{
					icon: 'cards',
					label: 'Sections',
					sectionId: 'sections'
				},
				{
					icon: 'page-template',
					label: 'layouts',
					sectionId: 'layouts'
				}
			]
		),

	/**
	 * Sidebar active section ID
	 * @default sections
	 * @memberof FragmentsEditorSidebarContent
	 * @private
	 * @review
	 * @type {string}
	 */
	_sectionId: Config
		.string()
		.internal()
		.value('sections')
};

Soy.register(FragmentsEditorSidebarContent, templates);

export {FragmentsEditorSidebarContent};
export default FragmentsEditorSidebarContent;