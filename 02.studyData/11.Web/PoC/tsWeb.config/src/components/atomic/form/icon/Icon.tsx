import css from "./Icon.module.css";

interface IconProps {
  /**
   * 아이콘 이름을 입력합니다.
   */
  name?: string;

  /**
   * 아이콘 컬러를 지정합니다.
   */
  color?: string;

  /**
   * 아이콘 사이즈를 지정합니다.
   */
  size?: string;
}

/**
 * Icon UI 문서
 */
export const Icon = ({ name ="", color, size }: IconProps) => {
  const sizePx = size + "px";
  return (
    <span
      class="material-symbols-outlined"
      style={{ color: color, fontSize: sizePx }}
    >
      {name}
    </span>
  );
};
