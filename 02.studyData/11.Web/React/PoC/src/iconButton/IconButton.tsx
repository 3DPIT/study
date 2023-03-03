import { Button, Icon } from 'components/atomic';
import css from './IconButton.module.css';

interface IconButtonProps {
    /**
     * 버튼 아이콘 이름을 입력합니다.
     */
    name: string;

    /**
     * 버튼 컬러를 지정합니다.
     */
    color?: string;

    /**
     * 버튼 크기를 지정합니다.
     */
    size?: string;

    /**
     * 버튼 클릭시 동작을 지정합니다.
     */
    onClick?: () => void;
}

/**
 * IconButton UI 문서
 */
export const IconButton = ({ name = '', color, size, ...props }: IconButtonProps) => {
    return (
        <Button {...props}>
            <Icon name={name} color={color} size={size}></Icon>
        </Button>
    );
};
