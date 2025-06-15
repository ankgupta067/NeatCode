# Testing Practices Cheat Sheet

## Testing Libraries and Frameworks

- Jest: Primary testing framework
- @testing-library/react: For testing React components
- @testing-library/user-event: For simulating user interactions

## Mocking and Stubbing

### Jest Mocks

```javascript
jest.mock('module-name');
jest.spyOn(object, 'method').mockImplementation(() => mockReturnValue);
```

### Manual Mocks

```javascript
const mockFunction = jest.fn().mockReturnValue(expectedValue);
```

## Fake Implementations

### API Responses

```javascript
const fakeApiResponse = {
  data: [
    { id: 1, name: 'Item 1' },
    { id: 2, name: 'Item 2' }
  ]
};
```

### Context Providers

```javascript
const MockProvider = ({ children }) => (
  <Context.Provider value={mockContextValue}>
    {children}
  </Context.Provider>
);
```

## Testing Strategies

### Component Testing

- Render components using `render` from @testing-library/react
- Use `screen` to query rendered elements
- Simulate user interactions with `fireEvent` or `userEvent`

```javascript
test('component renders correctly', () => {
  render(<Component />);
  expect(screen.getByText('Expected Text')).toBeInTheDocument();
});
```

### Asynchronous Testing

- Use `async/await` with `findBy` queries for asynchronous operations
- Utilize `waitFor` for more complex scenarios

```javascript
test('async operation', async () => {
  render(<AsyncComponent />);
  await waitFor(() => {
    expect(screen.getByText('Loaded')).toBeInTheDocument();
  });
});
```

### API Call Testing

- Mock fetch or axios for API calls
- Use `mockResolvedValue` or `mockRejectedValue` for different scenarios

```javascript
jest.mock('axios');
axios.get.mockResolvedValue({ data: mockData });
```

### Redux Testing

- Test reducers, actions, and selectors separately
- Use `redux-mock-store` for testing connected components

```javascript
const mockStore = configureStore([]);
const store = mockStore(initialState);
render(
  <Provider store={store}>
    <ConnectedComponent />
  </Provider>
);
```

## Best Practices

1. Use descriptive test names
2. Group related tests using `describe` blocks
3. Use `beforeEach` for common setup
4. Clean up after tests using `afterEach`
5. Prefer specific assertions over generic ones
6. Test both success and error scenarios
7. Use snapshot testing sparingly and intentionally

## Common Patterns

- AAA (Arrange-Act-Assert) pattern for structuring tests
- Given-When-Then style for behavior-driven development
- Use of factory functions to create test data

## Coverage

- Aim for high test coverage, especially for critical paths
- Use Jest's coverage reports to identify untested areas