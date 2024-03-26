# Package com.adevinta.spark.components.bottomsheet

[BottomSheet](https://spark.adevinta.com/1186e1705/p/67d41e-bottom-sheet/b/02056b)
A bottom sheet is a UI component commonly used in mobile applications to present additional content
or options from the bottom of the screen.
It is a modal component that slides up from the bottom of the screen and covers the entire screen.

#### BottomSheet

```kotlin
fun ModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    showHandle: Boolean = true,
    contentTopPadding: Dp,,
    sheetState: SheetState = rememberModalBottomSheetState(),
    content: @Composable BoxScope.() -> Unit,
)
```
