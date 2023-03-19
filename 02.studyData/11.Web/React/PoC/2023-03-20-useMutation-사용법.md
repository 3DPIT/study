---
title: useMutation-사용법
date: 2023-03-20 05:01:00 +0900
Category: useMutation
---

# useMutation

## 공식 문서 내용

```
 const {
   data,
   error,
   isError,
   isIdle,
   isLoading,
   isPaused,
   isSuccess,
   mutate,
   mutateAsync,
   reset,
   status,
 } = useMutation(mutationFn, {
   mutationKey,
   onError,
   onMutate,
   onSettled,
   onSuccess,
   retry,
   retryDelay,
   useErrorBoundary,
   meta,
 })
 
 mutate(variables, {
   onError,
   onSettled,
   onSuccess,
 })

```

- 옵션

  mutationFn: (변수: TVariables) => Promise<TData>
  필수
  비동기 작업을 수행하고 프로미스를 반환하는 함수입니다.
  변수는 돌연변이가 mutationFn에 전달할 객체입니다.
  mutationKey: 문자열
  선택 사항
  돌연변이 키를 설정하여 쿼리클라이언트.setMutationDefaults로 설정된 기본값을 상속하거나 개발 도구에서 돌연변이를 식별할 수 있습니다.
  onMutate: (변수: TVariables) => Promise<TContext | void> | TContext | void
  옵션
  이 함수는 돌연변이 함수가 실행되기 전에 실행되며 돌연변이 함수가 받을 것과 동일한 변수를 전달받습니다.
  변이가 성공하기를 바라며 리소스에 대한 낙관적 업데이트를 수행할 때 유용합니다.
  이 함수에서 반환된 값은 변이 실패 시 onError 및 onSettled 함수에 모두 전달되며, 낙관적 업데이트를 롤백하는 데 유용할 수 있습니다.
  onSuccess: (데이터: TData, 변수: TVariables, 컨텍스트?: TContext) => Promise<unknown> | void
  선택적
  이 함수는 변이가 성공하면 실행되며 변이의 결과를 전달받습니다.
  프로미스가 반환되면 계속 진행하기 전에 기다렸다가 해결됩니다.
  onError: (err: TError, variables: TVariables, context?: TContext) => Promise<unknown> | void
  선택적
  이 함수는 변이에서 오류가 발생하면 실행되며 오류를 전달합니다.
  프로미스가 반환되면 계속 진행하기 전에 기다렸다가 해결됩니다.
  onSettled: (데이터: TData, 오류: TError, 변수: TVariables, 컨텍스트?: TContext) => Promise<unknown> | void
  옵션
  이 함수는 변형을 성공적으로 가져오거나 오류가 발생했을 때 실행되며 데이터 또는 오류를 전달받습니다.
  프로미스가 반환되면 계속 진행하기 전에 기다렸다가 해결합니다.
  재시도: 부울 | 숫자 | (실패 횟수: 숫자, 오류: TError) => 부울
  기본값은 0입니다.
  false이면 실패한 변형을 다시 시도하지 않습니다.
  true이면 실패한 돌연변이가 무한히 재시도됩니다.
  숫자(예: 3)로 설정하면 실패한 돌연변이 수가 해당 숫자에 도달할 때까지 돌연변이를 다시 시도합니다.
  retryDelay: 숫자 | (retryAttempt: 숫자, 오류: TError) => 숫자
  이 함수는 retryAttempt 정수와 실제 오류를 수신하고 다음 시도 전에 적용할 지연 시간(밀리초)을 반환합니다.
  시도 => Math.min(시도 > 1 ? 2 ** 시도 * 1000 : 1000, 30 * 1000)과 같은 함수는 지수 백오프를 적용합니다.
  시도 => 시도 * 1000과 같은 함수는 선형 백오프를 적용합니다.
  useErrorBoundary: 정의되지 않음 | 부울 | (오류: TError) => 부울
  기본값은 정의되지 않은 전역 쿼리 구성의 useErrorBoundary 값입니다.
  렌더링 단계에서 돌연변이 오류가 발생하고 가장 가까운 오류 경계로 전파되도록 하려면 이 값을 true로 설정합니다.
  오류 경계에 오류를 던지는 동작을 비활성화하려면 거짓으로 설정합니다.
  함수로 설정하면 에러가 전달되며 에러 경계에 에러를 표시할지(true), 에러를 상태로 반환할지(false)를 나타내는 부울을 반환해야 합니다.
  메타: 레코드<스트링, 알 수 없음>
  선택 사항
  설정하면 필요에 따라 사용할 수 있는 변이 캐시 항목에 추가 정보를 저장합니다. 이 정보는 변형을 사용할 수 있는 곳이면 어디에서나 액세스할 수 있습니다(예: MutationCache의 onError, onSuccess 함수).
  반환값

  mutate: (변수: TVariables, { onSuccess, onSettled, onError }) => void
  변수와 함께 호출하여 돌연변이를 트리거하고 useMutation에 전달된 옵션을 선택적으로 재정의할 수 있는 돌연변이 함수입니다.
  변수를 사용할 수 있습니다: TVariables
  옵션
  mutationFn에 전달할 변수 객체입니다.
  나머지 옵션은 위에서 사용Mutation 훅에서 설명한 것과 동일한 옵션을 확장합니다.
  여러 요청을 하는 경우, 가장 최근에 호출한 후에만 onSuccess가 실행됩니다.
  mutateAsync: (변수: TVariables, { onSuccess, onSettled, onError }) => Promise<TData>
  mutate와 유사하지만 대기할 수 있는 프로미스를 반환합니다.
  상태: 문자열
  가 될 것입니다:
  돌연변이 함수가 실행되기 전의 유휴 초기 상태입니다.
  변이가 현재 실행 중이면 로드 중입니다.
  마지막 변이 시도가 오류를 발생시킨 경우 error.
  마지막 변이 시도가 성공하면 success.
  isIdle, isLoading, isSuccess, isError: 상태로부터 파생된 부울 변수
  데이터: 정의되지 않음 | 알 수 없음
  기본값은 미정의입니다.
  쿼리에 대해 마지막으로 성공적으로 해결된 데이터입니다.
  오류: null | TError
  오류가 발생한 경우 쿼리에 대한 오류 객체입니다.
  reset: () => void
  변이 내부 상태를 정리하는 함수(즉, 변이를 초기 상태로 재설정).

---

## 찾아서 공부한 내용

- useQuery와 다르게 mutation은
  - 데이터를 생성/ 업데이트/ 삭제시 사용
- mutation의 성공을 바라면서 미리 UI부터 변화시켜주는 optimistic update기능도 좋은 경험 제공

```react
import {useMutation}  from "react-query";
const {data, isLoading, mutate, mutateAsync} = useMutation(mutationFn options);

mutate(variables,{
  onError,
  onSettled,
  onSuccess,
});
```

### options

- **mutationFn (variables: TVables) => Promise<TData>**
  - Required
  - 비동기 작업을 수행하고 프로미스를 반환하는 함수
    - api요청하는 함수
  - variables는 mutate가 전달하는 객체
- **onMutate**: (variables: TVariables) => Promise<TContext | void> | Context | void
  - onMutate는 mutation 함수가 싱행되기 전에 실행되고,
    - mutation함수가 받을 동일한 변수가 전달
  - optmistic update 사용시 유용한 함수
- **onSuccess**: (data: TData, variables: TVarables, context?: TContext) => Promise<unknown> | void
  - mutation이 성공하고 결과를 전달할 때 실행
- **onError**: (err: TError, variables: TVarialbes, context?: TContext) => Promise<unknown> | void
  - onError는 mutation이 error를 만났을 때 실행
- **onSettled**: (data: TData, error: TError, variables: TVariables, context?: TContext) => Promise<unknown> | void
  - mutation이 성공해서 성공한 데이터 또는 error가 전달될 때 실행
    - 성공하든 실패하든 무조건 결과가 전달

### Returns

- #### `mutate: (variables: TVariables, { onSuccess, onSettled, onError }) => void`

  - mutate를 호출해서 mutation을 실행
  - variables는 mutationFn에 전달하는 객체
  - onSuccess, onSettled, onError는 Mutation option에 대한 것
    - 두곳에서 추가 콜백 (onSuccess, onSettled, onError)을 실행하는 경우
      - useMutation의 추가 콜백 -> mutate의 추가 콜백 순서로 실행
      - 컴포넌트가 unmount 되면 추가 콜백이 실행되지 않으니 주의

  ``` react
  useMutation(addTodo, {
     onSuccess: (data, variables, context) => {
       // I will fire first
     },
     onError: (error, variables, context) => {
       // I will fire first
     },
     onSettled: (data, error, variables, context) => {
       // I will fire first
     },
    });
  
  mutate(todo, {
     onSuccess: (data, variables, context) => {
       // I will fire second!
     },
     onError: (error, variables, context) => {
       // I will fire second!
     },
     onSettled: (data, error, variables, context) => {
       // I will fire second!
     },
  });
  
  ```

  - #### `mutateAsync: (variables: TVariables, { onSuccess, onSettled, onError }) => Promise<TData>`

    - mutatie와 같으나 promise를 반환

  ### 실제 사용해보기

  ```react
  import { useMutation } from "react-query";
  import axios from 'axios';
  
  interface TodoType {
    id: number;
    todo: string;
  }
  
  const addTodo = async (newTodo: TodoType): Promise<TodoType> => {
    const { data } = await axios.post<TodoType>(`/todos`, newTodo);
    return data;
  };
  // api 요청하는 함수(addTodo) 를 작성하지 않았을 경우
  const { mutate, isLoading, isError, error, isSuccess } = useMutation(addTodo);
  
  const { mutate, isLoading, isError, error, isSuccess } = useMutation(newTodo => {
    return axios.post<TodoType>('/todos', newTodo);
  });
  // api 요청하는 함수(addTodo) 를 작성했을 경우
  
  export default function App() {
    return (
      <div>
        {
          isLoading ? (
            'Adding todo...'
          ) : (
          <>
            {isError && <p>error: {error.message}</p>}
              
            {isSuccess && <p>Todo added!</p>}
              
            <button
              onClick={() => {
                mutate({ id: 1, todo: 'useMutation 예제' })
              }}
            >
                 작성 완료
            </button>
          </>
          )
        }
      </div>
    );
  }
  ```

## 참고자료

[[React Query] 리액트 쿼리 useMutation 실용 편(custom hook 으로 사용해보자)](https://velog.io/@kimhyo_0218/React-Query-%EB%A6%AC%EC%95%A1%ED%8A%B8-%EC%BF%BC%EB%A6%AC-useMutation-%EC%8B%A4%EC%9A%A9-%ED%8E%B8custom-hook-%EC%9C%BC%EB%A1%9C-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EC%9E%90)