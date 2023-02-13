import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import { Button } from "./Button";

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: "Components/atomic/form/Button",
  component: Button,
  // More on argTypes: https://storybook.js.org/docs/react/api/argtypes
  argTypes: {
    children: { control: { type: "text" } },
    backgroundColor: { control: "color" },
  },
} as ComponentMeta<typeof Button>;

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template: ComponentStory<typeof Button> = (args) => <Button {...args} />;

export const ButtonMain = Template.bind({});
// More on args: https://storybook.js.org/docs/react/writing-stories/args
ButtonMain.args = {
  label: "Button",
};

export const Default = Template.bind({});
// More on args: https://storybook.js.org/docs/react/writing-stories/args
Default.args = {
  varient: "",
  label: "Button",
};

export const Danger = Template.bind({});
Danger.args = {
  varient: "Danger",
  label: "Button",
};
export const Warn = Template.bind({});
Warn.args = {
  varient: "Warn",
  label: "Button",
};
export const Info = Template.bind({});
Info.args = {
  varient: "Info",
  label: "Button",
};

export const Small = Template.bind({});
Small.args = {
  size: "Small",
  label: "Button",
};

export const Medium = Template.bind({});
Medium.args = {
  size: "Medium",
  label: "Button",
};

export const Large = Template.bind({});
Large.args = {
  size: "Large",
  label: "Button",
};
