import { ComponentStory, ComponentMeta } from '@storybook/react';
import { IconButton } from './IconButton';

export default {
    title: 'Components/molecules/iconButton',
    component: IconButton,
    argTypes: {},
} as ComponentMeta<typeof IconButton>;

const Template: ComponentStory<typeof IconButton> = (args) => <IconButton {...args} />;

export const IconButtonMain = Template.bind({});

IconButtonMain.args = {
    name: 'add',
};
