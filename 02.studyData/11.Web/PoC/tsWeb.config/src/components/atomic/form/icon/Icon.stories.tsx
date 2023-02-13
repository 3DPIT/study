import { ComponentStory, ComponentMeta } from "@storybook/react";
import { Icon } from "./Icon";

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: "Components/atomic/form/icon",
  component: Icon,
  // More on argTypes: https://storybook.js.org/docs/react/api/argtypes
  argTypes: {},
} as ComponentMeta<typeof Icon>;

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template: ComponentStory<typeof Icon> = (args) => <Icon {...args} />;

export const IconMain = Template.bind({});
// More on args: https://storybook.js.org/docs/react/writing-stories/args
IconMain.args = {
  name: "add",
};
