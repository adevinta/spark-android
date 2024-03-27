# Package com.adevinta.spark.components.bottomsheet

[BottomSheet](https://spark.adevinta.com/1186e1705/p/67d41e-bottom-sheet/b/02056b)
A bottom sheet is a UI component commonly used in mobile applications to present additional content
or options from the bottom of the screen.
It is a modal component that slides up from the bottom of the screen and covers the entire screen.

#### BottomSheet

```kotlin
fun BottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    showHandle: Boolean = true,
    contentTopPadding: Dp, ,
    sheetState: SheetState = rememberModalBottomSheetState(),
    content: @Composable BoxScope.() -> Unit,
)
```

# BottomSheet content with / No handle Example

| Light                                              | Dark                                               |
|----------------------------------------------------|----------------------------------------------------|
| ![](../../images/bottomsheet_dark_with_handle.png) | ![](../../images/bottomsheet_dark_with_handle.png) |
| ![](../../images/bottomsheet_light_no_handle.png)  | ![](../../images/bottomsheet_dark_no_handle.png)   |

# BottomSheet content behind handle Example

![](../../images/bottomsheet_content_behind_handle.png)

#### BottomSheetScaffold

```kotlin
fun BottomSheetScaffold(
    sheetContent: @Composable BoxScope.() -> Unit,
    content: @Composable (PaddingValues) -> Unit,
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    showHandle: Boolean = true,
    sheetContentTopPadding: Dp = if (showHandle) ContentTopPadding else ContentTopPaddingNoHandle,
    screenContentPadding: Dp = ContentTopPadding,
    sheetSwipeEnabled: Boolean = true,
    topBar: @Composable (() -> Unit)? = null,
    snackbarHost: @Composable (androidx.compose.material3.SnackbarHostState) -> Unit,
)
```

# BottomSheetScaffold Example

![](../../images/bottomsheetscaffold.png)
