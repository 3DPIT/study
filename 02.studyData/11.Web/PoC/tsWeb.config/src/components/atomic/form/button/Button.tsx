import React, { ReactNode } from "react";
import css from "./Button.module.css";

interface ButtonProps {
  /**
   * 상황별 색상 지정이 가능합니다.
   */
  varient?: "Default" | "Danger" | "Warn" | "Info";

  /**
   * What background color to use
   */
  backgroundColor?: string;

  /**
   * How large should the button be?
   */
  size?: "Small" | "Medium" | "Large";

  /**
   * 라벨 입력은 필수 입니다.
   */
  label?: string;

  /**
   * 상황에 맞게 컴포넌트를 넣으시면됩니다.
   */
  children?: ReactNode;

  /**
   * Optional click handler
   */
  onClick?: () => void;
}

/**
 * Button UI 문서
 */
export const Button = ({
  varient = "Default",
  size = "Medium",
  backgroundColor,
  label,
  children,
  ...props
}: ButtonProps) => {
  const sizeMode = {
    Small: css.buttonSmall,
    Medium: css.buttonMedium,
    Large: css.buttonLarge,
  };
  const colorMode = {
    Default: css.buttonDefault,
    Danger: css.buttonDanger,
    Warn: css.buttonWarn,
    Info: css.buttonInfo,
  };
  return (
    <button
      type="button"
      className={
        css.buttonMain + " " + sizeMode[size] + " " + colorMode[varient]
      }
      style={{ backgroundColor }}
      {...props}
    >
      {label}
      {children}
    </button>
  );
};
