## story book 문법 변경

## ICON 변경

- before

  ```tsx
  import { AtomicIcon } from "./AtomicIcon";
  import { ComponentStory, ComponentMeta } from '@storybook/react';
  
  export default {
  	title: 'shared/atoms/Icon',
  	component: AtomicIcon,
  	argTypes: {
  		name: { control: { type: 'text' } },
  	},
  } as ComponentMeta<typeof AtomicIcon>;
  
  const Template: ComponentStory<typeof AtomicIcon> = (args) => <AtomicIcon {...args} />;
  
  export const Name = Template.bind({});
  Name.args = {
  	name: '',
  };
  
  ```

- after

  ```tsx
  import { AtomicIcon } from './AtomicIcon';
  import type { Meta, StoryObj } from '@storybook/react';
  
  const meta: Meta<typeof AtomicIcon> = {
      title: 'shared/atoms/Icon',
      component: AtomicIcon,
      argTypes: {
          name: { control: { type: 'text' } },
      },
  };
  
  export default meta;
  type Story = StoryObj<typeof AtomicIcon>;
  
  export const Name: Story = {
      args: {
          name: 'Delete',
      },
  };
  
  ```

## 버튼 변경

- before

  ```tsx
  import { AtomicButton } from './AtomicButton';
  import { ComponentStory, ComponentMeta } from '@storybook/react';
  
  export default {
  	title: 'shared/atoms/Button',
  	component: AtomicButton,
  	argTypes: {
  		onClick: { action: 'clicked' },
  		startIcon: { control: { type: 'text' } },
  	},
  } as ComponentMeta<typeof AtomicButton>;
  
  const Template: ComponentStory<typeof AtomicButton> = (args) => <AtomicButton {...args} />;
  
  export const Label = Template.bind({});
  Label.args = {
  	children: 'BUTTON Label',
  };
  
  export const Variant = Template.bind({});
  Variant.args = {
  	variant: 'text',
  	children: 'BUTTON Variant',
  };
  
  export const Color = Template.bind({});
  Color.args = {
  	color: 'secondary',
  	children: 'BUTTON Color',
  };
  
  export const Size = Template.bind({});
  Size.args = {
  	children: 'BUTTON Size',
  };
  
  export const Clickable = Template.bind({});
  Clickable.args = {
  	children: 'Clickable Button', 
  	onClick: () => alert('Button clicked!'),
  };
  
  export const StartIcon = Template.bind({});
  StartIcon.args = {
  	children: 'Clickable Button',
  	startIcon: '',
  };
  
  ```

- after

  ```tsx
  import { AtomicButton } from './AtomicButton';
  import type { Meta, StoryObj } from '@storybook/react';
  
  const meta: Meta<typeof AtomicButton> = {
      title: 'shared/atoms/Button',
      component: AtomicButton,
      argTypes: {
          onClick: { action: 'clicked' },
          startIcon: { control: { type: 'text' } },
      },
  };
  
  export default meta;
  type Story = StoryObj<typeof AtomicButton>;
  
  export const Label: Story = {
      args: {
          children: 'BUTTON Label',
      },
  };
  
  export const Variant: Story = {
      args: {
          variant: 'text',
          children: 'BUTTON Variant',
      },
  };
  
  export const Color = {
      args: {
          color: 'secondary',
          children: 'BUTTON Color',
      },
  };
  
  export const Size = {
      args: {
          children: 'BUTTON Size',
      },
  };
  
  export const Clickable = {
      args: {
          children: 'Clickable Button',
          onClick: () => alert('Button clicked!'),
      },
  };
  
  export const StartIcon = {
      args: {
          children: 'Clickable Button',
          startIcon: '',
      },
  };
  
  ```

- 이전과 비교해서

  - before (7버전 아래)

    ```tsx
    import { ComponentStory, ComponentMeta } from '@storybook/react';
    ```

  - after (베타 7버전 기준)

    ```tsx
    import type { Meta, StoryObj } from '@storybook/react';
    ```

    