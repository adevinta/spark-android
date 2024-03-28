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
    content = {
        Text(
            text = "BottomSheet Content",
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        )
    }
)
```

# BottomSheet content with / No handle Example

| Light                                              | Dark                                               |
|----------------------------------------------------|----------------------------------------------------|
| ![](../../images/bottomsheet_dark_with_handle.png) | ![](../../images/bottomsheet_dark_with_handle.png) |
| ![](../../images/bottomsheet_light_no_handle.png)  | ![](../../images/bottomsheet_dark_no_handle.png)   |

# BottomSheet content behind handle Example

```kotlin
fun BottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    showHandle: Boolean = true,
    contentTopPadding = 0.dp, 
    sheetState: SheetState = rememberModalBottomSheetState(),
    content = {
        Box(
            contentAlignment = Alignment.TopCenter,
        ) {
            Image(
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth(),
                model = "https://upload.wikimedia.org/wikipedia/commons/f/fd/Pink_flower.jpg",
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
        }
    }
)
```
![](../../images/bottomsheet_content_behind_handle.png)

#### BottomSheetScaffold

```kotlin
fun BottomSheetScaffold(
    sheetContent = {
    Text(
        text = "Sheet Content",
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    )
},
    content = {
        Text(
            text = "Screen Content",
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        )
    },
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
